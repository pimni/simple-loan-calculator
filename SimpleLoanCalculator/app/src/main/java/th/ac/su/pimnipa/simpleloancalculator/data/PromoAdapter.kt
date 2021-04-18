package th.ac.su.pimnipa.simpleloancalculator.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_detail.view.*
import th.ac.su.pimnipa.simpleloancalculator.R

class PromoAdapter(private val context: Context, private val dataSource:ArrayList<Promo>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.activity_result,null)

        rowView.tvName.text = dataSource[position].promo_name
        rowView.tvPromo.text = dataSource[position].promo_code
        rowView.tvCaption.text = dataSource[position].promo_description

        val res = context.resources

        val drawableId:Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)
        rowView.imgQR.setImageResource(drawableId)

        return rowView

    }
}