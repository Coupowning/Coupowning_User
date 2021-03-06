package kr.ac.coukingmama.userapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.user.UserApiClient

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        Handler().postDelayed({
            isToken()
            finish()
        }, 2000)
    }

    private fun isToken() {
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) { // 캐시에 토큰이 존재하지 않으면 로그인 페이지로 이동
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else if (tokenInfo != null) { // 캐시에 토큰이 존재하면 메인 페이지로 이동
                val intent = Intent(getApplication(), MainActivity::class.java)
                intent.putExtra("userId", tokenInfo.id.toString()) // 사용자 고유 id
                startActivity(intent)
            }

        }

    }
}

