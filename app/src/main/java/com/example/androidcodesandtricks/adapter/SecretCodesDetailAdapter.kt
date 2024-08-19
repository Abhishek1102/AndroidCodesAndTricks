package com.example.androidcodesandtricks.adapter

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcodesandtricks.R
import com.example.androidcodesandtricks.model.SecretCodesDetailModel


class SecretCodesDetailAdapter(
    private val context: Context,
    private val secretCodesdetailList: ArrayList<SecretCodesDetailModel>,
) : RecyclerView.Adapter<SecretCodesDetailAdapter.SecretCodesdetailListViewHolder>() {

    class SecretCodesdetailListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_call: ImageView = itemView.findViewById(R.id.iv_call)
        var iv_caution: ImageView = itemView.findViewById(R.id.iv_caution)
        var iv_share: ImageView = itemView.findViewById(R.id.iv_share)
        var tv_secretCodesdetailListMaintitle: TextView = itemView.findViewById(R.id.tv_secretCodeDetail_Maintitle)
        var tv_secretCodesdetailListTitle: TextView = itemView.findViewById(R.id.tv_secretCodeDetail_title)
        var tv_secretCodesdetailListDescription: TextView = itemView.findViewById(R.id.tv_secretCodeDetail_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecretCodesdetailListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_secretcode_detail, parent, false)
        return SecretCodesdetailListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return secretCodesdetailList.size
    }

    override fun onBindViewHolder(holder: SecretCodesdetailListViewHolder, position: Int) {
        holder.tv_secretCodesdetailListMaintitle.setText(secretCodesdetailList.get(position).mainTitle)
        holder.tv_secretCodesdetailListTitle.setText(secretCodesdetailList.get(position).title)
        holder.tv_secretCodesdetailListDescription.setText(secretCodesdetailList.get(position).code)

        holder.iv_call.setOnClickListener {

            openDialPad(secretCodesdetailList.get(position).code)

        }

        holder.iv_share.setOnClickListener {

            shareSecretCode(secretCodesdetailList.get(position).mainTitle, secretCodesdetailList.get(position).title, secretCodesdetailList.get(position).code)

        }

        holder.iv_caution.setOnClickListener {

            showCautionDialog()

        }

    }

    private fun openDialPad(code: String) {
        val numberCode = Intent()
        numberCode.setAction(Intent.ACTION_DIAL)
        numberCode.setData(Uri.parse("tel:" + Uri.encode("${code}")))
        context.startActivity(numberCode)
    }

    private fun shareSecretCode(mainTitle: String?, title: String?, code: String?) {
        // Build the share body text based on whether mainTitle is null or empty
        val shareBody = buildString {
            if (!mainTitle.isNullOrEmpty()) {
                append(mainTitle)
                append("\n\n")
            }
            if (!title.isNullOrEmpty()) {
                append(title)
                append("\n")
            }
            if (!code.isNullOrEmpty()) {
                append(code)
            }
        }

        // Create the share intent
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareBody)
        }

        // Start the sharing activity
        context.startActivity(Intent.createChooser(shareIntent, "Share using"))
    }

    private fun showCautionDialog() {
        // Inflate the custom layout
        val dialogView = LayoutInflater.from(context).inflate(R.layout.custom_caution_dialog, null)

        // Create the dialog
        val builder = AlertDialog.Builder(context).apply {
            setView(dialogView)
            setCancelable(true)
        }

        // Create and show the dialog
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val lv_ok: LinearLayout = dialogView.findViewById(R.id.lv_ok)

        lv_ok.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


}