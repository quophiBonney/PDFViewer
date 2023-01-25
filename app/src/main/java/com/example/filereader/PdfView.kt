package com.example.filereader

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

@Suppress("DEPRECATION")
class PdfView : AppCompatActivity() {
    private lateinit var pdfView : PDFView
    private val pdfSelectionCode = 100
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)

        pdfView = findViewById(R.id.pdfView)
        selectPdfFromStorage()
    }

    private fun selectPdfFromStorage() {
        val browseStorage = Intent(Intent.ACTION_GET_CONTENT)
        browseStorage.type = "application/pdf"
        browseStorage.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(Intent.createChooser(browseStorage, "Select PDF File"),pdfSelectionCode)
    }

    private fun showPdfFromUri(uri : Uri?){
        pdfView.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == pdfSelectionCode && resultCode == Activity.RESULT_OK && data != null){
            val selectedPdf = data.data
            showPdfFromUri(selectedPdf)

        }
    }
}