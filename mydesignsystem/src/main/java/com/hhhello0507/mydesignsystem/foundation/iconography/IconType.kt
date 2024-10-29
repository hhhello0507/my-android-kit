package com.hhhello0507.mydesignsystem.foundation.iconography

import androidx.annotation.DrawableRes
import com.hhhello0507.mydesignsystem.R

enum class IconType {
    DETAIL,
    EXPAND_ARROW, NORMAL_ARROW, STOP_ARROW, CURVE_ARROW,
    CROSS_LINE, CROSS_RING, CROSS_FILL,
    ADD_LINE, ADD_RING, ADD_FILL,
    EXCLAMATION_LINE, EXCLAMATION_FILL,
    HEART_LINE, HEART_FILL,
    RADIO_LINE, RADIO_FILL,
    CHECK_LINE, CHECK_RING, CHECK_FILL,
    BOOKMARK_LINE, BOOKMARK_FILL,
    SHOW, HIDE,
    ALARM, ALARM_DISABLED,
    BOOK, CALENDAR, CAMERA, CHAT, CROWN, HOME, MANAGE, MOON, PERSON, PING, SEND, SETTING, STAR, TRASH, UTENSILS, PEN,
    ADD_EMOJI, BLANK, COPY, FILE, LOGOUT, LOUD_SPEAKER, PHOTO, SEARCH, SUBSTACK, WRITE,
    APPLE_LOGO, GOOGLE_LOGO;

    val icon: Int
        @DrawableRes get() = when (this) {
            DETAIL -> R.drawable.ic_detail
            EXPAND_ARROW -> R.drawable.ic_expand_arrow
            NORMAL_ARROW -> R.drawable.ic_normal_arrow
            STOP_ARROW -> R.drawable.ic_stop_arrow
            CURVE_ARROW -> R.drawable.ic_curve_arrow
            CROSS_LINE -> R.drawable.ic_cross_line
            CROSS_RING -> R.drawable.ic_cross_ring
            CROSS_FILL -> R.drawable.ic_cross_fill
            ADD_LINE -> R.drawable.ic_add_line
            ADD_RING -> R.drawable.ic_add_ring
            ADD_FILL -> R.drawable.ic_add_fill
            EXCLAMATION_LINE -> R.drawable.ic_exclamation_line
            EXCLAMATION_FILL -> R.drawable.ic_exclamation_fill
            HEART_LINE -> R.drawable.ic_heart_line
            HEART_FILL -> R.drawable.ic_heart_fill
            RADIO_LINE -> R.drawable.ic_radio_line
            RADIO_FILL -> R.drawable.ic_radio_fill
            CHECK_LINE -> R.drawable.ic_check_line
            CHECK_RING -> R.drawable.ic_check_ring
            CHECK_FILL -> R.drawable.ic_check_fill
            BOOKMARK_LINE -> R.drawable.ic_bookmark_line
            BOOKMARK_FILL -> R.drawable.ic_bookmark_fill
            SHOW -> R.drawable.ic_show
            HIDE -> R.drawable.ic_hide
            ALARM -> R.drawable.ic_alarm
            ALARM_DISABLED -> R.drawable.ic_alarm_disabled
            BOOK -> R.drawable.ic_book
            CALENDAR -> R.drawable.ic_calendar
            CAMERA -> R.drawable.ic_camera
            CHAT -> R.drawable.ic_chat
            CROWN -> R.drawable.ic_crown
            HOME -> R.drawable.ic_home
            MANAGE -> R.drawable.ic_manage
            MOON -> R.drawable.ic_moon
            PERSON -> R.drawable.ic_person
            PING -> R.drawable.ic_ping
            SEND -> R.drawable.ic_send
            SETTING -> R.drawable.ic_setting
            STAR -> R.drawable.ic_star
            TRASH -> R.drawable.ic_trash
            UTENSILS -> R.drawable.ic_utensils
            PEN -> R.drawable.ic_pen
            ADD_EMOJI -> R.drawable.ic_add_emoji
            BLANK -> R.drawable.ic_blank
            COPY -> R.drawable.ic_copy
            FILE -> R.drawable.ic_file
            LOGOUT -> R.drawable.ic_logout
            LOUD_SPEAKER -> R.drawable.ic_loud_speaker
            PHOTO -> R.drawable.ic_photo
            SEARCH -> R.drawable.ic_search
            SUBSTACK -> R.drawable.ic_substack
            WRITE -> R.drawable.ic_write
            APPLE_LOGO -> R.drawable.ic_apple_logo
            GOOGLE_LOGO -> R.drawable.ic_google_logo
        }
}