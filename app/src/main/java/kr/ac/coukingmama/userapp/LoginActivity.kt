package kr.ac.coukingmama.userapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.Timestamp
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import kotlinx.android.synthetic.main.activity_login.*
import kr.ac.coukingmama.userapp.data.*
import kr.ac.coukingmama.userapp.data.user.History
import kr.ac.coukingmama.userapp.data.user.StoreList
import kr.ac.coukingmama.userapp.data.user.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var userId: String
    val service = RetrofitClient.apiService
    lateinit var timeStamp : Timestamp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        kakao_login.setOnClickListener{
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
                UserApiClient.instance.loginWithKakaoTalk(this@LoginActivity, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this@LoginActivity, callback = callback)
            }
        }
    }

    internal val callback : (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e("login","로그인 실패- $error")
        } else if (token != null) {
            UserApiClient.instance.me { user, error ->
                userId = user!!.id.toString()
                val data = User("${userId}",
                    listOf(StoreList(0,null,null,null,null,null
                        , listOf(History
                            ("timeStamp", 0),),)
                    )
                )
                service.createUser(data).enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        if(response.isSuccessful) { // 통신 성공
                            Log.d("user", "Post user 성공" + response.body().toString())
                        }else { // 통신 실패 (응답코드 3xx, 4xx 등)
                            Log.d("user", "Post user 실패" + response.code() + response.body().toString())
                        }
                    }
                    override fun onFailure(call: Call<User>, t: Throwable) { // 통신 실패 (인터넷 끊김, 예외 발생 등)
                        Log.d("user",t.message.toString())
                        Log.d("user","fail")
                    }
                })
            }
            Log.d("login","로그인성공")
            startActivity(Intent(getApplication(), MainActivity::class.java))
            finish()
        }
    }

}