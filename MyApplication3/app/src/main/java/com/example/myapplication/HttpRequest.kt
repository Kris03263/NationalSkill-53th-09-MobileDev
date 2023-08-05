package com.example.myapplication

import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpRequest {
    fun PostReques(url:String,body:JSONObject,result: (Any?) -> Unit){
        Thread{
            try{
                with(URL(url).openConnection() as HttpURLConnection){
                    requestMethod = "POST"
                    doOutput = true
                    readTimeout = 3000
                    addRequestProperty("Content-Type","application/json")
                    addRequestProperty("Accept","application/json")
                    outputStream.write(
                        body.toString().toByteArray(),
                        0,
                        body.toString().toByteArray().size
                    )
                    BufferedReader(InputStreamReader(inputStream)).use{
                        var response = StringBuffer()
                        var text = it.readLine()
                        while(text != null){
                            response.append(text)
                            text = it.readLine()
                        }
                        it.close()
                        disconnect()
                        result(response.toString())
                        println(response.toString())
                    }
                }
            }catch (e: java.lang.Exception){
                println(e.message)
            }
        }.start()
    }
}