package edu.hkbu.comp.comp4097.infoday.data

data class Event (
  val id: Int,
  val title: String,
  val deptId: String,
  var bookmarked: Boolean = false
)
