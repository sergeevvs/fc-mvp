package sergeevvs.fc_mvp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.databinding.FragmentCardBinding
import sergeevvs.fc_mvp.interfaces.ICardView

class CardFragment : Fragment(), ICardView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentCardBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_card,
            container,
            false
        )

        return binding.root
    }
}