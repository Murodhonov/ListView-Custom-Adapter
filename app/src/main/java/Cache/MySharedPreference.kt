package Cache

import Models.Food
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreference {
    private const val NAME = "KeshXotiraga"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences(NAME, MODE)
    }
    private inline fun SharedPreferences.edit(operations:(SharedPreferences.Editor)-> Unit){
        val editor = edit()
        operations(editor)
        editor.apply()
    }
    var obektString:ArrayList<Food>
        get() = gsonStringToArray(preferences.getString("obekt","[]")!!)
        set(value) = preferences.edit{
            it.putString("obekt", arrayToGsonString(value))
        }
    private fun arrayToGsonString(arrayList: ArrayList<Food>):String{
        return Gson().toJson(arrayList)
    }
    private fun gsonStringToArray(gsonString:String):ArrayList<Food>{
        val typeToken = object : TypeToken<ArrayList<Food>>(){}.type
        return Gson().fromJson(gsonString,typeToken)
    }
}