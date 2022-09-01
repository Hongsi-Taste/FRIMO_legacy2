package com.gachon.frimo.diary

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.Gravity
import android.widget.Toast
import com.gachon.frimo.databinding.ActivityMyDiaryBinding
import com.gachon.frimo.databinding.FragmentMyDiaryChatBinding
import com.gachon.frimo.databinding.FragmentMyDiaryGalleryBinding
import com.gachon.frimo.databinding.FragmentMyDiarySecretBinding
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.OnMenuItemClickListener
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem

//TODO: add powermenu
//TODO: find reason why no permissions Error
class MyDiary : AppCompatActivity() {

    //뷰바인딩
    private lateinit var binding: ActivityMyDiaryBinding
    private lateinit var bindingChat: FragmentMyDiaryChatBinding
    private lateinit var bindingSecret: FragmentMyDiarySecretBinding
    private lateinit var bindingGallery: FragmentMyDiaryGalleryBinding

    //PowerMenu
    private lateinit var menu: PowerMenu

    //필요한 클래스 미리 불러놓기
    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var recognitionListener: RecognitionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyDiaryBinding.inflate(layoutInflater)
        bindingChat = FragmentMyDiaryChatBinding.inflate(layoutInflater)
        setContentView(bindingChat.root)

        //Powermenu
        menu = PowerMenu.Builder(this)
            .addItem(PowerMenuItem("Diary",false))
            .addItem(PowerMenuItem("Secret",false))
            .addItem(PowerMenuItem("Gallery",false))
            .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT)
            .setTextColor(Color.BLACK)
            .setTextGravity(Gravity.CENTER)
            .setOnMenuItemClickListener(changeMenuItemClickListener)
            .build()

        //TODO: add permission check and of not satisfied, request permission
        //intent에 Recognizer넣어서 선언.
        var intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, packageName)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR")

        setListener()

        //버튼 누르면 듣기 시작.
        bindingChat.chatRecord.setOnClickListener {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
            speechRecognizer.setRecognitionListener(recognitionListener)
            speechRecognizer.startListening(intent)
        }
    }

    //RecognitionListener 확장
    private fun setListener(){
        recognitionListener = object: RecognitionListener{
            //메세지 띄워서 녹음중이라는 것을 표시
            override fun onReadyForSpeech(params: Bundle?) {
                Toast.makeText(applicationContext, "Recording Start!", Toast.LENGTH_SHORT).show()
            }

            override fun onBeginningOfSpeech() {
                //TODO("Not yet implemented")
            }

            override fun onRmsChanged(rmsdB: Float) {
                //TODO("Not yet implemented")
            }

            override fun onBufferReceived(buffer: ByteArray?) {
                //TODO("Not yet implemented")
            }

            override fun onEndOfSpeech() {
                //TODO("Not yet implemented")
            }
            //에러메세지 출력
            override fun onError(error: Int) {
                var message: String
                when(error){
                    SpeechRecognizer.ERROR_AUDIO ->
                        message = "Audio Error"
                    SpeechRecognizer.ERROR_CLIENT ->
                        message = "Client Error"
                    SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS ->
                        message = "No permissions"
                    SpeechRecognizer.ERROR_NETWORK ->
                        message = "Network Error"
                    SpeechRecognizer.ERROR_NETWORK_TIMEOUT ->
                        message = "Network TIMEOUT"
                    SpeechRecognizer.ERROR_RECOGNIZER_BUSY ->
                        message = "Recognizer is busy"
                    SpeechRecognizer.ERROR_SERVER ->
                        message = "SERVER is weird"
                    SpeechRecognizer.ERROR_SPEECH_TIMEOUT ->
                        message = "Speech Time Exceeded"
                    else ->
                        message = "Unknown Error"
                }
                Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
            }
            //결과를 받아서 text로 출력.
            override fun onResults(results: Bundle?) {
                var matches: ArrayList<String>? = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                var resultToView: String = ""
                if (matches != null){
                    for(i in 0 until matches.size){
                        resultToView += matches[i]
                        //test용 라인
                        //bindingChat.resView.text = matches[i]
                    }
                    bindingChat.chatEdtText.setText(resultToView)
                }
            }

            override fun onPartialResults(partialResults: Bundle?) {
                //TODO("Not yet implemented")
            }

            override fun onEvent(eventType: Int, params: Bundle?) {
                //TODO("Not yet implemented")
            }

        }
    }

    //PowerMenu Item Click Listener
    private val changeMenuItemClickListener =
        OnMenuItemClickListener<PowerMenuItem> { position, item ->

//            when(position){
//                0 ->
//                1 ->
//                2 -> s
//            }
    }

    private fun fragmentChange(i:Int){

    }
}