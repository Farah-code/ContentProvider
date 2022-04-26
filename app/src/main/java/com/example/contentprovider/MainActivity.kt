package com.example.contentprovider

import android.Manifest
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.net.URI

class MainActivity : AppCompatActivity()
{
    lateinit var GetContact : Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    public fun buton_getcontact (view : View)
    {

    }

    private fun getPhoneContact ()
    {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,  Array<String>{Manifest.permission.READ_CONTACTS}, 0)
        }

       var contentResolver : ContentResolver = contentResolver
       var uri : Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
       var cursor : Cursor? = contentResolver.query(uri, null, null, null, null)

        Log.i("Contact Provider", "Total of # contact ::: " + Integer.toString(cursor!!.count))

        if (cursor.count > 0)
        {
            while (cursor.moveToNext())
            {
                val ContactName : String = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            }
        }

    }


}