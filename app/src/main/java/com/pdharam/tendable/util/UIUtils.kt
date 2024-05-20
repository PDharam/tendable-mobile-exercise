package mahindra.supplier.tpm.utils

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import com.pdharam.tendable.R


object UIUtils {
    private var progress: ProgressDialog? = null

    fun showProgress(context: Context, message: String?) {
        if (progress != null && progress!!.context === context) {
            if (progress!!.isShowing) {
                progress!!.dismiss()
            }
        } else {
            progress = null
            progress = ProgressDialog(context, R.style.MyAlertDialogStyle)
        }
        progress!!.setMessage(message)
        progress!!.setCancelable(false)
        progress!!.show()
    }

    fun hideProgress() {
        if (progress != null && progress!!.isShowing) {
            progress!!.dismiss()
        }
    }

    fun t(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }


}