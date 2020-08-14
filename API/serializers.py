from django.contrib.auth.models import User
from rest_framework.authtoken.models import Token
from rest_framework import serializers
from rest_framework.response import Response

from .models import (StudentProfile, UtamuAccount, Courses, Marks, NewsPosts, CarouselDisplay)


# ...creating a user
class UserSerializer(serializers.ModelSerializer):
    password2 = serializers.CharField(style={'input_type': 'password'}, write_only=True)
    password_1 = serializers.CharField(style={'input_type': 'password'}, write_only=True)

    class Meta:
        model = UtamuAccount
        fields = ('firstname', 'lastname', 'Uemail', 'residence', 'password_1', 'password2')
        depth = 1

    def create(self, validated_data):
        Uemail = self.validated_data['Uemail']
        lastname = self.validated_data['lastname']
        firstname = self.validated_data['firstname']
        residence = self.validated_data['residence']
        password1 = self.validated_data['password_1']
        password2 = self.validated_data['password2']

        if password1 != password2:
            return Response({"Message": "Passwords Dont match Correct this"})

        utamuuser = UtamuAccount(lastname=lastname, firstname=firstname, password=password1, Uemail=Uemail,
                                 residence=residence)
        utamuuser.save()
        uname = str(lastname) + ' ' + str(firstname)
        user = User(email=Uemail, username=uname)
        user.set_password(password2)
        user.save()
        Token.objects.create(user=user)

        return utamuuser


class CreatingSysUsers(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ('username', 'email', 'password')
        extra_kwargs = {'password': {'write_only': True}}

    def create(self, validated_data):
        user = User(email=validated_data['email'], username=validated_data['username'])
        user.set_password(validated_data['password'])
        user.save()
        Token.objects.create(user=user)
        return user


class StudentProfileSerializers(serializers.ModelSerializer):
    class Meta:
        model = StudentProfile
        fields = ('StudentId', 'StudentCourse', 'Studentprofiling_date', 'StudentRole')
        depth = 1


class CoursesSerializers(serializers.ModelSerializer):
    class Meta:
        model = Courses
        fields = ('course_name', 'added_date')
        depth = 1


class MarksSerializers(serializers.ModelSerializer):
    class Meta:
        model = Marks
        fields = ('student_marked', 'course_marked', 'course_marks', 'recorded_by', 'posting_date')
        depth = 3


class NewsPostsSerializers(serializers.ModelSerializer):
    class Meta:
        model = NewsPosts
        fields = ('poster_name', 'post_title', 'post_body', 'posting_date')
        depth = 2


class CarouselDisplaySerializers(serializers.ModelSerializer):
    image=serializers.ImageField(use_url=True)
    class Meta:
        model = CarouselDisplay
        fields = ['title', 'image', 'body', 'creationDate']
        depth = 1
