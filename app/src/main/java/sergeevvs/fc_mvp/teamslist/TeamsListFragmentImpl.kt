package sergeevvs.fc_mvp.teamslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.adapter.TeamsListAdapter
import sergeevvs.fc_mvp.data.TEAMS_LIST
import sergeevvs.fc_mvp.data.TeamsList
import sergeevvs.fc_mvp.databinding.FragmentListBinding
import sergeevvs.fc_mvp.repository.MainRepository
import javax.inject.Inject

@AndroidEntryPoint
class TeamsListFragmentImpl : Fragment(), TeamsListFragment {

    @Inject lateinit var presenter: TeamsListPresenter
    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.getSerializable(TEAMS_LIST)
                ?.let { presenter.attachTeamsList(it as TeamsList) }
    }

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

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = TeamsListAdapter(presenter)

        presenter.attachView(this)
        presenter.viewIsReady()

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(TEAMS_LIST, presenter.getTeamsList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun getNavController(): NavController {
        return findNavController()
    }

    override fun updateList() {
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}