package id.novian.binar.challengechapter3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import id.novian.binar.challengechapter3.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            sendBackData(it)
        }

    }

    private fun sendBackData(it: View) {
        val age = binding.insAge.text.toString().toInt()
        val address = binding.insAddress.text.toString()
        val job = binding.insJob.text.toString()

        val dataPersonal = DataPersonal(age, address, job)

        val bundle = Bundle()
        bundle.putParcelable(KEY_PARCEL, dataPersonal)

        setFragmentResult(REQUEST_OK, bundle)
        it.findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val KEY_PARCEL = "parcel"
        const val REQUEST_OK = "ok"
    }

}