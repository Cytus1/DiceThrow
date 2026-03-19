package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DieFragment : Fragment() {

    private val DIESIDE = "sidenumber"

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    lateinit var viewModel: DieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }

        viewModel = ViewModelProvider(this)[DieViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentRoll.observe(viewLifecycleOwner) {
            dieTextView.text = it.toString()
        }

        if (viewModel.currentRoll.value == 0) {
            throwDie()
        }

//        view.setOnClickListener{
//            throwDie()
//        }
    }

    fun throwDie() {
        viewModel.throwDie(dieSides)
    }

    fun throw20Die() {
        viewModel.throw20Die()
    }
}