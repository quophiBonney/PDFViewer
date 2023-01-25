package com.example.filereader

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val imageView = requireView().findViewById<View>(R.id.pdf) as ImageView
        val imageView1 = requireView().findViewById<View>(R.id.zip) as ImageView
        val imageView2 = requireView().findViewById<View>(R.id.word) as ImageView
        val imageView3 = requireView().findViewById<View>(R.id.allDocs) as ImageView
        imageView.setOnClickListener {
            val intent = Intent(activity, PdfView::class.java)
            startActivity(intent)
        }
        imageView1.setOnClickListener {
            val intent = Intent(activity, ZipView::class.java)
            startActivity(intent)
        }
        imageView2.setOnClickListener {
            val intent = Intent(activity, WordView::class.java)
            startActivity(intent)
        }
        imageView3.setOnClickListener {
            val intent = Intent(activity, AllDocsView::class.java)
            startActivity(intent)
        }
    }

}