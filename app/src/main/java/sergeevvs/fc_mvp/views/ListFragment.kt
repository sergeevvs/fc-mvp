package sergeevvs.fc_mvp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sergeevvs.footballcards.data.Team
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.databinding.FragmentListBinding
import sergeevvs.fc_mvp.interfaces.IListView
import sergeevvs.fc_mvp.models.ListModel
import sergeevvs.fc_mvp.presenters.ListPresenter

class ListFragment : Fragment(), IListView {

    lateinit var binding: FragmentListBinding
    lateinit var presenter: ListPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        presenter = ListPresenter(ListModel())
        presenter.attachView(this)
        presenter.viewIsReady()

        return binding.root
    }

    override fun showTeams(teams: List<Team>) {
        binding.recyclerView // .setData, .updateList что то вроде такого
    }


}