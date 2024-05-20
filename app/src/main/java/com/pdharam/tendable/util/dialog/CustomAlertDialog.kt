import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.pdharam.tendable.R
import com.pdharam.tendable.databinding.CustomAlertDialogBinding


@SuppressLint("ValidFragment")
class CustomAlertDialog() : DialogFragment(),
    View.OnClickListener {

    private var okListener: OKlistener? = null
    private var cancelListener: CancelListener? = null
    private lateinit var okBtnText: String
    private lateinit var cancelBtnText: String
    private lateinit var title: String
    private lateinit var msg: String
    private lateinit var binding: CustomAlertDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CustomAlertDialogBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
        setUp()
        init()
        setListeners()
    }

    private fun setUp() {


        if (::title.isInitialized)
            binding.tvTitle.text = title
        else
            binding.tvTitle.text = resources.getString(R.string.app_name)

        if (::msg.isInitialized)
            binding.tvMsg.text = msg

        if (::okBtnText.isInitialized)
            binding.btnDialogOk.text = okBtnText
        else
            binding.btnDialogOk.text = resources.getString(R.string.ok)

        if (::cancelBtnText.isInitialized) {
            binding.btnDialogCancel.text = cancelBtnText
            binding.btnDialogCancel.visibility = View.VISIBLE
        }
    }

    private fun setListeners() {
        binding.btnDialogOk.setOnClickListener(this)
        binding.btnDialogCancel.setOnClickListener(this)
    }

    private fun init() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_dialog_ok -> {
                if (okListener != null)
                    okListener!!.onClick(this)
                else
                    dismiss()
            }

            R.id.btn_dialog_cancel -> {
                if (cancelListener != null)
                    cancelListener!!.onClick(this)
                else
                    dismiss()
            }
        }
    }

    fun setOKClickListener(okListener: OKlistener): CustomAlertDialog {
        this.okListener = okListener
        return this
    }

    fun setCancelClickListener(cancelListener: CancelListener): CustomAlertDialog {
        this.cancelListener = cancelListener
        return this
    }

    interface OKlistener {
        fun onClick(dialog: CustomAlertDialog)
    }

    interface CancelListener {
        fun onClick(dialog: CustomAlertDialog)
    }

    fun setOkBtnText(okBtnText: String): CustomAlertDialog {
        this.okBtnText = okBtnText
        return this
    }

    fun setCancelBtnText(cancelBtnText: String): CustomAlertDialog {
        this.cancelBtnText = cancelBtnText
        return this
    }

    fun setTitle(title: String): CustomAlertDialog {
        this.title = title
        return this
    }

    fun setMsg(msg: String): CustomAlertDialog {
        this.msg = msg
        return this
    }

}