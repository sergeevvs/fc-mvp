package sergeevvs.fc_mvp.adapter


import android.graphics.drawable.PictureDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sergeevvs.fc_mvp.R
import sergeevvs.fc_mvp.data.ID
import sergeevvs.fc_mvp.data.Team
import sergeevvs.fc_mvp.databinding.TeamCardBinding
import sergeevvs.fc_mvp.svg.SvgSoftwareLayerSetter
import sergeevvs.fc_mvp.teamslist.TeamsListPresenter

class TeamsListAdapter(private val presenter: TeamsListPresenter) :
    RecyclerView.Adapter<TeamsListAdapter.TeamCardHolder>() {

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

        fun bindTeam(team: Team, navController: NavController?) {
            binding.team = team
            binding.root.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt(ID, team.id)
                navController?.navigate(
                    R.id.action_listFragment_to_cardFragment,
                    bundle
                )
            }
            binding.executePendingBindings()

            Glide.with(binding.root.context)
                    .`as`(PictureDrawable::class.java)
                    .load(team.crestUrl)
                    .listener(SvgSoftwareLayerSetter())
                    .into(binding.cardImage)
        }
    }
}