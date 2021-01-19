package sergeevvs.fc_mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.adapter.SquadAdapter
import sergeevvs.fc_mvp.databinding.FragmentSquadBinding
import sergeevvs.fc_mvp.presenter.SquadListPresenter

class SquadListFragment : Fragment(), MvpView {

    private lateinit var binding: FragmentSquadBinding
    private val presenter = SquadListPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_squad,
            container,
            false
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = SquadAdapter(presenter)

        presenter.attachView(this)
        presenter.viewIsReady()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun getNavController(): NavController {
        return findNavController()
    }

    fun updateList() {
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}