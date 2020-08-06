from django.contrib.auth import authenticate
from django.shortcuts import render
from rest_framework.exceptions import PermissionDenied
from rest_framework.permissions import IsAuthenticated, IsAdminUser
from rest_framework.response import Response
from rest_framework import viewsets, generics, status
from rest_framework.decorators import api_view
from rest_framework.views import APIView
from .serializers import *
from .models import StudentProfile, StaffMemberProfile, CarouselDisplay


# Create your views here.

# ------this is for creating users

class UserCreate(viewsets.ModelViewSet):
    authentication_classes = ()
    permission_classes = ()
    queryset = UtamuAccount.objects.order_by('-id')
    serializer_class = UserSerializer


class LoginView(APIView):
    permission_classes = ()

    def post(self, request, ):
        username = request.data.get("username")
        password = request.data.get("password")
        user = authenticate(username=username, password=password)
        if user:
            return Response({"token": user.auth_token.key, "username": user.username})
            # return Response({"token": "logged in"})
        else:
            return Response({"error": "Wrong Credentials"}, status=status.HTTP_400_BAD_REQUEST)


class Students(viewsets.ModelViewSet):
    permission_classes = (IsAuthenticated,)
    queryset = StudentProfile.objects.order_by('-id')
    serializer_class = StudentProfileSerializers

    def create(self, request, *args, **kwargs):
        if not request.user.is_superuser:
            raise PermissionDenied(
                request.user.username + " You can not delete this studentProfile. Only Marks_Recorders are deleters")
        return super().create(request, *args, **kwargs)

    def destroy(self, request, *args, **kwargs):
        if not request.user.is_superuser:
            raise PermissionDenied(
                request.user.username + " You can not delete this studentProfile. Only Marks_Recorders are deleters")
        return super().destroy(request, *args, **kwargs)

    def update(self, request, *args, **kwargs):
        if not request.user.is_superuser:
            raise PermissionDenied(
                request.user.username + " You can not update this studentProfile. Only Marks_Recorders are updaters")
        return super().update(request, *args, **kwargs)


class Courses(viewsets.ModelViewSet):
    permission_classes = (IsAuthenticated,)
    queryset = Courses.objects.order_by('-id')
    serializer_class = CoursesSerializers

    def create(self, request, *args, **kwargs):
        if not request.user.is_superuser:
            raise PermissionDenied(
                request.user.username + " You can not create this course, you dont have the rights to")
        return super().create(request, *args, **kwargs)

    def destroy(self, request, *args, **kwargs):
        course = Courses.objects.get(pk=self.kwargs["pk"])
        if not request.user == course.poster_name:
            raise PermissionDenied(
                request.user.username + " You can not delete this course. Only Marks_Recorders are deleters")
        return super().destroy(request, *args, **kwargs)

    def update(self, request, *args, **kwargs):
        course = Courses.objects.get(pk=self.kwargs["pk"])
        if not request.user == course.poster_name:
            raise PermissionDenied(
                request.user.username + " You can not update this course. Only Marks_Recorders are updaters")
        return super().update(request, *args, **kwargs)


class Marks(viewsets.ModelViewSet):
    permission_classes = (IsAuthenticated,)
    queryset = Marks.objects.order_by('-id')
    serializer_class = MarksSerializers

    def create(self, request, *args, **kwargs):
        if not request.user.is_superuser:
            raise PermissionDenied(
                request.user.username + " You can not create this course, you dont have the rights to")
        return super().create(request, *args, **kwargs)

    def destroy(self, request, *args, **kwargs):
        marks = Marks.objects.get(pk=self.kwargs["pk"])
        if not request.user == marks.poster_name:
            raise PermissionDenied(
                request.user.username + " You can not delete the Marks. Only Marks_Recorders are deleters")
        return super().destroy(request, *args, **kwargs)

    def update(self, request, *args, **kwargs):
        marks = Marks.objects.get(pk=self.kwargs["pk"])
        if not request.user == marks.poster_name:
            raise PermissionDenied(
                request.user.username + " You can not update the Marks. Only Marks_Recorders are updaters")
        return super().update(request, *args, **kwargs)


class NewsPostsView(viewsets.ModelViewSet):
    # permission_classes = (IsAuthenticated,)  # using this for allowing anyone with authentication
    permission_classes = (IsAuthenticated, IsAdminUser)  # used for allowing admins only
    queryset = NewsPosts.objects.order_by('-id')
    serializer_class = NewsPostsSerializers

    def create(self, request, *args, **kwargs):
        if not request.user.is_authenticated:
            raise PermissionDenied(
                request.user.username + " You were not authenticated ")
        return super().create(request, *args, **kwargs)

    def destroy(self, request, *args, **kwargs):
        newspost = NewsPosts.objects.get(pk=self.kwargs["pk"])
        if not request.user == newspost.poster_name:
            raise PermissionDenied(
                request.user.username + " You can not delete this newspost. Only creaters are deleters")
        return super().destroy(request, *args, **kwargs)

    def update(self, request, *args, **kwargs):
        newspost = NewsPosts.objects.get(pk=self.kwargs["pk"])
        if not request.user == newspost.poster_name:
            raise PermissionDenied(
                request.user.username + " You can not update this newspost. Only creaters are updaters")
        return super().update(request, *args, **kwargs)


class CarouselDisplay(viewsets.ModelViewSet):
    permission_classes = (IsAuthenticated,)
    queryset = CarouselDisplay.objects.order_by('-id')
    serializer_class = CarouselDisplaySerializers


@api_view(['GET', ])
def getallstudentprofiles(self):
    students = StudentProfile.objects.all()
    serializer = StudentProfileSerializers(students, many=True)
    return Response({"all students": serializer.data})


@api_view(['GET', 'POST'])
def obtain_auth_token(self):
    for user in User.objects.all():
        Token.objects.get_or_create(user=user)
    return Response({"all students": "created tokens for the already existant users"})

# class SysUserCreation(generics.CreateAPIView):
#     authentication_classes = ()
#     permission_classes = ()
#     serializer_class = CreatingSysUsers
