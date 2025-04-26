package com.example.basic_navigation

const val DETAIL_ARGUMENT_KEY =  "id"
const val DETAIL_ARGUMENT_KEY_2 = "name"

sealed class Screen(val route: String){
    data object Home: Screen(route = "home_screen")
    // specify the Required Argument which is passed in this component "/{arg name}"
    data object Detail: Screen(route = "detail_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY_2}"){
        //Sending single argument
        fun passId(id: Int): String{
            //return  "detail_screen/$id"
            return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
        }

        //sending two arguments
        fun passNameAndId(id: Int, name: String): String{
            return  "detail_screen/$id/$name"
        }
    }

     //Sending an optional argument

//    data object Detail: Screen(route = "detail_screen?id={id"){
//        fun passId(id: Int): String{
//            return "detail_screen?id=$id"
//        }
//
//        fun passNameAndId(
//            id: Int = 0,
//            name: String = "Vivek"
//        ): String{
//            return "detail_screen?id=$id&name=$name"
//        }
//    }


}