package com.example.deliveryapp.core.presentation.designsystem.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.deliveryapp.databinding.DialogSuccessBinding

class SuccessDialog: DialogFragment() {
    private var title: String = ""
    private var description: String = ""
    private var isDialogCancelable: Boolean = true
    private var positiveAction: Action = Action.Empty

    companion object {
        fun create(
            title: String = "",
            description: String = "",
            isDialogCancelable: Boolean = true,
            positiveAction: Action = Action.Empty,
        ): SuccessDialog = SuccessDialog().apply {
            this.title = title
            this.description = description
            this.isDialogCancelable = isDialogCancelable
            this.positiveAction = positiveAction
        }
    }

    override fun onStart() {
        super.onStart()
        val window = dialog?.window ?: return

        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val rootView = window.decorView.findViewById<View>(android.R.id.content)
        setMargins(rootView, 50, 20, 50, 20)

    }

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogSuccessBinding.inflate(requireActivity().layoutInflater)

        binding.tvTitle.text = title
        binding.tvDescription.text = description
        binding.btnPositive.text = positiveAction.text
        binding.btnPositive.setOnClickListener { positiveAction.onClickListener(this) }
        isCancelable = isDialogCancelable

        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .setCancelable(isDialogCancelable)
            .create()
    }


    data class Action(
        val text: String,
        val onClickListener: (SuccessDialog) -> Unit
    ) {
        companion object {
            val Empty = Action("") {}
        }
    }

    private fun setMargins(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val params = view.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(left, top, right, bottom)
            view.requestLayout()
        }
    }
}