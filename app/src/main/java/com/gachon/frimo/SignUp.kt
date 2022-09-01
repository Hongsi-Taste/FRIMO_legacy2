package com.gachon.frimo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.gachon.frimo.databinding.SignUpBinding
import com.skydoves.needs.*

// Todo: 아래 사항 확인 필요
// AppCompatActivity extends FragmentActivity which extends ComponentActivity.
// 그래서 ComponentActivity()로 했을 때 돌아가고, AppCompatActivity에서는 안 돌아간다는 것을 알겠는데
// 왜 선배님의 코드에선 AppCompatActivity에서도 잘 돌아감???

class SignUp : ComponentActivity() {

    private lateinit var binding: SignUpBinding
    private lateinit var needs: Needs

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            buttonSignUp.setOnClickListener {
                it.showNeeds(needs)
            }
        }

        // Todo: confirm button 색 변경
        needs= createNeeds(baseContext) {
            title = "Permission instructions \nfor using this Android app."
            addNeedsItem(NeedsItem(null, "SD Card", "(Required)", "Access photos, media, and files on device."))
            addNeedsItem(NeedsItem(null, "Location", "(Required)", "Access this device's location."))
            addNeedsItem(NeedsItem(null, "Camera", "(Optional)", "Take pictures and record video."))
            addNeedsItem(NeedsItem(null, "Contact", "(Optional)", "Access this device's contacts."))
            addNeedsItem(NeedsItem(null, "SMS", "(Optional)", "Send and view SMS messages."))
            description = "The above accesses are used to better serve you."
            confirm = "Confirm"
            needsAnimation = NeedsAnimation.CIRCULAR
        }

        needs.setOnConfirmListener {
            needs.dismiss()
            startActivity(Intent(this, Login::class.java))
        }

    }
}