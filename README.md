# KotlinForLogin

![这里写图片描述](http://img.blog.csdn.net/20171205163357772?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveWVjaGFvYQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
> 废话：在Kotlin还不是正房的时候就听说过了，除了Java之外也能开发Android APP的一种语言，小众到鲜为人知，甚至介绍都不多。但是在谷歌大会宣布kotlin为官方语言之后，铺天盖地的都是关于kotlin的介绍和语法简介，出身豪门等等。
> 后来，J神也离开了Square去了Google，而且是Kotlin项目组。
> 到最近Kotlin1.2版本发布又是一波大范围的推送，而且在GitHub的排名也不断上升。
> Google一系列的动作都在加快Kotlin在Android领域取代Java的速度。甚至还有跨平台的骚操作。。

#### [Kotlin官方文档（英文版）](https://kotlinlang.org/docs/reference/)
#### [Kotlin官方文档（中文版）](https://www.kotlincn.net/docs/reference/)
#### [Anko——JetBrains开发的一个强大的库](https://github.com/Kotlin/anko)
#### [RxKotlin](https://github.com/ReactiveX/RxKotlin)
<br>

#### 以登录为例，小小练手，直接贴，看代码看注释

```
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

```

> 知识点就不复述了吧。。直接看文档都有的，网上也能搜到的，不过大多都是千篇一律翻译官方文档。
> 光看还是不行的，从kotlin坐上正房之后也在断断续续的看kotlin学习笔记，但实际上手还是多多少少的会遇到问题，准备找项目搞了，理论知识看再多，不如项目搞一波。

<br>
另外，Anko支持动态生成视图，且语法简单，结构清晰，但是不能预览，预览插件在这

> https://github.com/Kotlin/anko/wiki/Anko-Layouts#anko-support-plugin

其实效率也不是很高。。

<br>

Java 代码转换为 Kotlin
> ctrl +alt + shift + k
