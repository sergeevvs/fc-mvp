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
import sergeevvs.fc_mvp.RecyclerAdapter
import sergeevvs.fc_mvp.databinding.FragmentListBinding
import sergeevvs.fc_mvp.model.ListModel
import sergeevvs.fc_mvp.presenter.ListPresenter

class ListFragment : Fragment(), MvpView {

    lateinit var binding: FragmentListBinding

    private val presenter = ListPresenter(ListModel())
    private val adapter = RecyclerAdapter(presenter)
    private val llm = LinearLayoutManager(context)

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

        binding.recyclerView.layoutManager = llm
        binding.recyclerView.adapter = adapter

        presenter.attachView(this)
        presenter.viewIsReady()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    fun updateList() {
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun getNavController(): NavController {
        return findNavController()
    }
}