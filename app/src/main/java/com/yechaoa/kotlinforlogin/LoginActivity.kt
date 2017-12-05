package com.yechaoa.kotlinforlogin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

// : 表示继承，类型声明等
class LoginActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //不需要分号

        //apply plugin: 'kotlin-android-extensions'
        //添加插件可以直接拿xml文件中的id
        btn_login.setOnClickListener {
            //字符串拼接
            Log.i("tag", "${getUsername()}+${getPassword()}")
            if ("123" == (getUsername()) && "123" == (getPassword()))
                showDialog()
            else
                Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDialog() {
        alert("登录成功", "提示") {
            yesButton {
                //this指向是谁, ::class.java加载java文件
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }
            noButton {}
        }.show()
    }

    //自定义函数
    private fun getUsername(): String {
        //定义变量，? 表示可空
        val username = til_username.editText?.text.toString().trim()
        return if (TextUtils.isEmpty(username))
            ""
        else
            username
    }

    private fun getPassword(): String {
        val password = til_password.editText?.text.toString().trim()
        return if (TextUtils.isEmpty(password))
            ""
        else
            password
    }

    override fun onDestroy() {
        super.onDestroy()
        //AnkoLogger
        info("onDestroy")
    }

}
