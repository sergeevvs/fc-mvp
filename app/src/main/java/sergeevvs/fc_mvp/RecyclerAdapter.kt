package sergeevvs.fc_mvp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.databinding.TeamCardBinding
import sergeevvs.fc_mvp.interfaces.IListPresenter

class RecyclerAdapter(private val presenter: IListPresenter) :
    RecyclerView.Adapter<RecyclerAdapter.TeamCardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamCardHolder {
        return TeamCardHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.team_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamCardHolder, position: Int) {
        presenter.onBindTeamAtPosition(holder, position)
    }

    override fun getItemCount() = presenter.getTeamCount()

    class TeamCardHolder(private val binding: TeamCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindTeam(team: Team, listener: () -> Unit) {
            binding.team = team
            binding.root.setOnClickListener { listener() }
            binding.executePendingBindings()

            Glide.with(binding.root)
                    .load(team.crestUrl)
                    .into(binding.cardImage)
        }
    }
}
