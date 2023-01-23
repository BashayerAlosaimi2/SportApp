package com.example.pifsportapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pifsportapp.R
import com.example.pifsportapp.ViewModel.MatchViewModel
import com.example.pifsportapp.adapter.MatchCreatedAdapter
import com.example.pifsportapp.data.MatchCreatedData
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout
import java.util.*
import kotlin.collections.ArrayList



class playFragment : Fragment() {

    lateinit var shimmring : ShimmerFrameLayout

   //  lateinit var matchList: ArrayList<MatchCreatedData>
   // lateinit var matchCreatedAdapter: MatchCreatedAdapter
    lateinit var createdMatchRV: RecyclerView
   // private lateinit var VM: MatchViewModel

    /*private val VM by lazy {
        ViewModelProvider(this)[MatchViewModel::class.java]


    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }
      @SuppressLint("SuspiciousIndentation", "NotifyDataSetChanged")
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          createdMatchRV = view.findViewById(R.id.rvCreatedMatch)
       //  VM = ViewModelProvider(this).get(VM::class.java)
         // VM= ViewModelProvider(this).get(VM::class.java)

        createdMatchRV.layoutManager = LinearLayoutManager(this.context)

         // VM = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(appl)).get(VM.class)
       /*   VM.getMatch().observe(viewLifecycleOwner) {
              //  val isLandscape = view.findViewById<FrameLayout>(R.id.flDetails) != null
              createdMatchRV.adapter = MatchCreatedAdapter(it, VM)

          }*/


          /*  shimmring  = view.findViewById(R.id.shimmer_view_container)
            shimmring.showShimmer(true)*/
         // shimmring.setShimmer(Shimmer.AlphaHighlightBuilder().setAutoStart(false).build())


        //  shimmring.hideShimmer()
          //TODO
      /////  matchList= ArrayList()


          //createdMatchRV = view.findViewById(R.id.rvCreatedMatch)

          // on below line we are initializing our list

          // on below line we are creating a variable
          // for our grid layout manager and specifying
          // column count as 2

        //  val layoutManager = GridLayoutManager(context, 1,RecyclerView.HORIZONTAL,true)

      /*    createdMatchRV.layoutManager = layoutManager

          // on below line we are initializing our adapter
            //TODO  ////  matchCreatedAdapter = MatchCreatedAdapter(matchList)

          // on below line we are setting
          // adapter to our recycler view.
          //TODO
          createdMatchRV.adapter = matchCreatedAdapter

          // on below line we are notifying adapter
          // that data has been updated.
          matchCreatedAdapter.notifyDataSetChanged()*/

      }


    }

// SHIMMERING FOR HOME FRAGMENT It dosen't hide

/*
<com.facebook.shimmer.ShimmerFrameLayout
android:id="@+id/shimmer_view_container"
android:layout_width="match_parent"
android:layout_height="200dp"
app:layout_constraintBottom_toTopOf="@+id/tv_lastMatches"
app:layout_constraintEnd_toEndOf="parent"
app:layout_constraintStart_toStartOf="parent"
app:layout_constraintTop_toBottomOf="@+id/textView2">

<LinearLayout
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="horizontal">

<include layout="@layout/new_match_shrimmer_item" />
<include layout="@layout/new_match_shrimmer_item" />
<include layout="@layout/new_match_shrimmer_item" />


</LinearLayout>
</com.facebook.shimmer.ShimmerFrameLayout>
*/
