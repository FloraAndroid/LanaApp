package com.archeticture.flora.lanaapp.detailSide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_itemdetail_detail.*
import kotlinx.android.synthetic.main.itemdetail_detail.view.*

/**
 * A fragment representing a single ItemDetail detail screen.
 * This fragment is either contained in a [ItemDetailListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailDetailActivity]
 * on handsets.
 */
class ItemDetailDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.toolbar_layout?.title = item?.content
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.itemdetail_detail, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.itemdetail_detail.text = it.details
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
