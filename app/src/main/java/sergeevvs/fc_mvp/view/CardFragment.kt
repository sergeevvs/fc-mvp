package sergeevvs.fc_mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.databinding.FragmentCardBinding
import sergeevvs.fc_mvp.model.CardModel
import sergeevvs.fc_mvp.presenter.CardPresenter

class CardFragment : Fragment(), MvpView {

    lateinit var binding: FragmentCardBinding

    private val presenter = CardPresenter(CardModel())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_card,
            container,
            false
        )

        return binding.root
    }

    override fun getNavController(): NavController {
        return findNavController()
    }
}