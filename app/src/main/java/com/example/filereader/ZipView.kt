package com.example.filereader

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView

class ZipView : AppCompatActivity() {
    lateinit var zipView: PDFView
    val pdfSelectionCode = 100
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zip_view)
        zipView = findViewById(R.id.zip)
        selectPdfFromStorage()
    }

    private fun selectPdfFromStorage() {
        val browseStorage = Intent(Intent.ACTION_GET_CONTENT)
        browseStorage.type = "application/zip"
        browseStorage.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(Intent.createChooser(browseStorage, "Select ZIP File"),pdfSelectionCode)
    }

    fun showPdfFromUri(uri : Uri?){
        zipView.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == pdfSelectionCode && resultCode == Activity.RESULT_OK && data != null){
            val selectedPdf = data.data
            showPdfFromUri(selectedPdf)

        }
    }
}