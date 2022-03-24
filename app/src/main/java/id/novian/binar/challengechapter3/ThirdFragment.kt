package id.novian.binar.challengechapter3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import id.novian.binar.challengechapter3.FourthFragment.Companion.KEY_PARCEL
import id.novian.binar.challengechapter3.FourthFragment.Companion.REQUEST_OK
import id.novian.binar.challengechapter3.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(REQUEST_OK) { _, bundle ->
            val dataFourth: DataPersonal =
                bundle.getParcelable<DataPersonal>(KEY_PARCEL) as DataPersonal

            val age = dataFourth.age
            val address = dataFourth.address
            val job = dataFourth.job

            if (age % 2 == 0) {
                binding.age.apply {
                    text = String.format("$age, usia anda genap")
                    visibility = View.VISIBLE
                }
            } else {
                binding.age.apply {
                    text = String.format("$age, usia anda ganjil")
                    visibility = View.VISIBLE
                }
            }

            binding.address.apply {
                text = address
                visibility = View.VISIBLE
            }

            binding.job.apply {
                text = job
                visibility = View.VISIBLE
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getName()

        binding.btnMove.setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
        }

    }

    private fun getName() {
        val name = ThirdFragmentArgs.fromBundle(arguments as Bundle).keyName
        binding.name.text = name
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}