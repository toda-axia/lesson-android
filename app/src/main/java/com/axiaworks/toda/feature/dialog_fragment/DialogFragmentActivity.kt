package com.axiaworks.toda.feature.dialog_fragment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.axiaworks.toda.R
import com.axiaworks.toda.databinding.ActivityDialogFragmentBinding
import java.text.SimpleDateFormat
import java.util.*

class DialogFragmentActivity : AppCompatActivity(), LogCountListener {
    private lateinit var binding: ActivityDialogFragmentBinding
    private var dialogFragmentFragment: DialogFragmentFragment? = null

    companion object {
        fun callingIntent(context: Context) = Intent(context, DialogFragmentActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dialog_fragment)
        dialogFragmentFragment = supportFragmentManager.findFragmentById(R.id.dialogfragment_container) as DialogFragmentFragment
    }

    override fun logSelectedButton(log: String) {
        val logDateTime: String = getTimeStamp()
        val dialogLog = "$logDateTime: ユーザーは'$log'を選択しました"
        dialogFragmentFragment?.setLogToAdapter(dialogLog)
    }

    private fun getTimeStamp(): String {
        val date = Date()
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return format.format(date)
    }
}
