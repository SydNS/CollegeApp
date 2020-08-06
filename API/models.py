from django.conf import settings
from django.contrib.auth.base_user import AbstractBaseUser
from django.contrib.auth.models import User
from django.db import models
from django.db.models.signals import post_save
from django.dispatch import receiver
from django.utils import timezone

# Create your models here.
from rest_framework.authtoken.models import Token

from django.conf.global_settings import MEDIA_ROOT


class UtamuAccount(models.Model):
    firstname = models.CharField(max_length=20, unique=True)
    lastname = models.CharField(max_length=20, unique=True)
    Uemail = models.EmailField(max_length=30, unique=True)
    password = models.CharField(max_length=20)
    residence = models.CharField(max_length=30)
    reg_date = models.DateTimeField(default=timezone.now)

    class Meta:
        ordering = ('reg_date',)

    def __str__(self):
        name = str(self.firstname).upper()
        name2 = str(self.lastname).upper()
        Uname = name + ' ' + name2
        return Uname


# @receiver(post_save, sender=settings.AUTH_USER_MODEL)
# def create_auth_token(sender, instance=None, created=True, **kwargs):
#     if created:
#         Token.objects.create(user=instance)


class MemberRole(models.Model):
    STATUS_CHOICES = (
        ('student', 'Student'),
        ('staff', 'Staff'),
        ('parent', 'Parent'),
        ('teaching_staff', 'Teachingstaff'),
        ('nonteachingstaff', 'NonTeachingstaff')
    )
    role_name = models.CharField(max_length=30, choices=STATUS_CHOICES, default='student')
    role_name_added_date = models.DateTimeField(default=timezone.now)

    class Meta:
        ordering = ('role_name',)

    def __str__(self):
        return self.role_name


class Courses(models.Model):
    course_name = models.CharField(max_length=40, unique=True)
    added_date = models.DateTimeField(default=timezone.now)

    class Meta:
        ordering = ('added_date',)

    def __str__(self):
        return self.course_name


class StudentProfile(models.Model):
    StudentId = models.ForeignKey(UtamuAccount, on_delete=models.CASCADE, related_name="Member_name", null=True)
    StudentRole = models.ForeignKey(MemberRole, on_delete=models.CASCADE, related_name="member_role_name", null=True)
    StudentCourse = models.ForeignKey(Courses, on_delete=models.CASCADE, related_name="member_course_name", null=True)
    Studentprofiling_date = models.DateTimeField(default=timezone.now)

    class Meta:
        ordering = ('Studentprofiling_date',)

    def __str__(self):
        return self.StudentId.firstname


class StaffMemberProfile(models.Model):
    StaffMemberId = models.ForeignKey(UtamuAccount, on_delete=models.CASCADE, related_name="Staff_Member_name",
                                      null=True)
    StaffMemberCourse = models.ForeignKey(Courses, on_delete=models.CASCADE, related_name="staff_members_course_name",
                                          null=True)
    StaffMemberRole = models.ForeignKey(MemberRole, on_delete=models.CASCADE, related_name="staff_members_role_name",
                                        null=True)
    StaffMemberprofiling_date = models.DateTimeField(default=timezone.now)

    class Meta:
        ordering = ('StaffMemberprofiling_date',)

    def __str__(self):
        return self.StaffMemberId.firstname


class Marks(models.Model):
    student_marked = models.ForeignKey(StudentProfile, on_delete=models.CASCADE, related_name="marks", null=True)
    course_marked = models.ForeignKey(Courses, on_delete=models.CASCADE, related_name="marked_course", null=True)
    course_marks = models.CharField(max_length=10)
    recorded_by = models.ForeignKey(StaffMemberProfile, on_delete=models.CASCADE, related_name="recorder")
    posting_date = models.DateTimeField(default=timezone.now)

    def __str__(self):
        return self.course_marks


class Messages(models.Model):
    sendername = models.ForeignKey(StudentProfile, on_delete=models.CASCADE, related_name="sender_name", null=True)
    recievername = models.ForeignKey(StudentProfile, on_delete=models.CASCADE, related_name="reciever_name", null=True)
    # recievername = models.CharField(max_length=40)
    messagetitle = models.CharField(max_length=30)
    messagebody = models.TextField(max_length=100000)
    sendingDate = models.DateTimeField(default=timezone.now)

    def __str__(self):
        return self.messagetitle


class NewsPosts(models.Model):
    poster_name = models.ForeignKey(StudentProfile, on_delete=models.CASCADE, related_name="posters_name",
                                    null=True)
    post_title = models.CharField(max_length=30)
    post_body = models.TextField(max_length=100000)
    posting_date = models.DateTimeField(default=timezone.now)

    class Meta:
        ordering = ('posting_date',)

    def __str__(self):
        return self.post_title


class CarouselDisplay(models.Model):
    title = models.CharField(max_length=20)
    body = models.TextField(max_length=100000)
    image = models.FileField(upload_to=MEDIA_ROOT, null=True, blank=False)
    creationDate = models.DateTimeField(default=timezone.now)

    #
    def __str__(self):
        return self.title

# class AccountManager(AbstractBaseUser):
#     email = models.EmailField(max_length=30,verbose_name='email',unique=True)
#     last_login = models.DateTimeField(verbose_name='last login', default=timezone.now)
#     date_joined = models.DateTimeField(verbose_name='date join', default=timezone.now)
#     is_active = models.BooleanField(default=True)
#     is_admin = models.BooleanField(default=False)
#     is_staff = models.BooleanField(default=False)
#     is_superuser = models.BooleanField(default=False)
#     password = models.CharField(max_length=20)
#     username = models.CharField(max_length=20)
#
#     USERNAME_FIELD = 'email'
#     REQUIRED_FIELDS = ['username']
#
#     objects = UtamuAccount()
#
#     def __str__(self):
#         return self.email
#
#     def has_perm(self, perm, obj=None):
#         return self.is_admin
