package kr.ac.coukingmama.userapp

import android.content.DialogInterface
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.kakao.sdk.user.UserApiClient
import kotlinx.android.synthetic.main.fragment_tab_profile.*

class TabProfileFragment : Fragment() {
    var userId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_tab_profile, container, false)
        var img = view.findViewById<ImageView>(R.id.qr_image)
        var logout = view.findViewById<TextView>(R.id.logout)
        userId = arguments?.getString("userId").toString()
        view.apply {
            val multiFormatWriter = MultiFormatWriter()
            val bitMatrix: BitMatrix =
                multiFormatWriter.encode(userId, BarcodeFormat.QR_CODE, 200, 200)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap: Bitmap = barcodeEncoder.createBitmap(bitMatrix)
            img.setImageBitmap(bitmap)
        }

        logout.setOnClickListener {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("로그아웃하시겠습니까?")
                .setPositiveButton("로그아웃",
                    DialogInterface.OnClickListener { dialog, id ->
                        UserApiClient.instance.logout { error ->
                            if (error != null) {
                                Log.d("logout", "로그아웃 실패 ${error}")
                            }else {
                                Log.d("logout", "로그아웃 성공 ")
                            }
                            val intent = Intent(activity, LoginActivity::class.java)
                            startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                        }
                    })
                .setNegativeButton("취소", null)
            builder.show()

        }
        return view
    }
}