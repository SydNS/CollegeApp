from django.contrib import admin
from .models import StudentProfile, MemberRole, Courses, Marks, Messages, NewsPosts, StaffMemberProfile, UtamuAccount, \
    CarouselDisplay


# from .models import Subjects, MemberProfile, NewsPosts, Marks, Messages


#

# Register your models here.
@admin.register(StudentProfile)
class StudentProfile(admin.ModelAdmin):
    list_display = (
        'StudentId',
        'StudentRole', 'Studentprofiling_date','StudentCourse')
    list_filter = ('StudentId', 'Studentprofiling_date')
    search_fields = ('StudentId', 'Studentcourse')
    ordering = ('Studentprofiling_date', 'StudentId')


@admin.register(StaffMemberProfile)
class StaffMemberProfile(admin.ModelAdmin):
    list_display = (
        'StaffMemberId',
        'StaffMemberRole', 'StaffMemberprofiling_date')
    list_filter = ('StaffMemberId', 'StaffMemberprofiling_date')
    search_fields = ('StaffMemberId', 'StaffMembercourse')
    ordering = ('StaffMemberprofiling_date', 'StaffMemberId')


@admin.register(MemberRole)
class MemberRole(admin.ModelAdmin):
    list_display = ('role_name', 'role_name_added_date')


@admin.register(Courses)
class Courses(admin.ModelAdmin):
    list_display = ('course_name', 'added_date')


@admin.register(Marks)
class Marks(admin.ModelAdmin):
    list_display = ('student_marked', 'course_marked', 'course_marks', 'recorded_by', 'posting_date')
    list_filter = ('student_marked', 'course_marked', 'recorded_by')
    search_fields = ('student_marked', 'recorded_by')
    ordering = ('recorded_by', 'student_marked')


@admin.register(NewsPosts)
class NewsPosts(admin.ModelAdmin):
    list_display = ('poster_name', 'post_title', 'post_body', 'posting_date')
    list_filter = ('poster_name', 'post_title', 'posting_date', 'post_title')
    search_fields = ('poster_name', 'post_title')
    ordering = ('posting_date', 'poster_name')


@admin.register(Messages)
class Messages(admin.ModelAdmin):
    list_display = ('sendername', 'recievername', 'messagetitle', 'messagebody', 'sendingDate')
    list_filter = ('sendername', 'recievername', 'messagetitle')
    search_fields = ('sendername', 'recievername')
    ordering = ('sendername', 'sendingDate')


@admin.register(UtamuAccount)
class UtamuAccount(admin.ModelAdmin):
    list_display = ('firstname', 'lastname', 'Uemail', 'password','residence',
                    'reg_date')
    list_filter = ('firstname', 'Uemail', 'reg_date')
    search_fields = ('firstname', 'Uemail')
    ordering = ('reg_date', 'firstname')


@admin.register(CarouselDisplay)
class CarouselDisplay(admin.ModelAdmin):
    list_display = ('title', 'body', 'image', 'creationDate')
    list_filter = ('title', 'body', 'creationDate')
    search_fields = ('title', 'image')
    ordering = ('creationDate','image')

