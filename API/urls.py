from django.urls import path, include
from rest_framework import routers

from . import views
from .views import Students, UserCreate, Courses, Marks,  LoginView

router = routers.DefaultRouter()
router.register('students', views.Students)
router.register('courses', views.Courses)
router.register('marks', views.Marks)
router.register('registration', views.UserCreate)
router.register('newsposts', views.NewsPostsView)
router.register('carouseldisplay', views.CarouselDisplay)

app_name = 'API'

urlpatterns = [

    path('', include(router.urls)),
    path('studentprofiles/', views.getallstudentprofiles, name='allstudentprofiles'),
    path("login/", LoginView.as_view(), name="login"),
    path("obtain/", views.obtain_auth_token, name="obtain")
]

# path('createusers/', SysUserCreation.as_view(), name='createusers')