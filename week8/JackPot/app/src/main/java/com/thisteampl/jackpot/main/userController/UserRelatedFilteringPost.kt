package com.thisteampl.jackpot.main.userController

data class UserRelatedFilteringPost (
    var pageNumber:Int,var pageSize:Int,var position:String,
    var regionFilter:String,var sortType:String, val stackFilter:List<String>
)