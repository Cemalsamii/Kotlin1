package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var girisemail = ""
        var girisparola = ""

        binding.tvtarifekle.setOnClickListener{

            var activity_tarifekle =LayoutInflater.from(this).inflate(R.layout.activity_tarifekle,null)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setView(activity_tarifekle)
            alertDialog.setNegativeButton("kapat"){dialog,which ->}
            alertDialog.show()

           val kaydetbutton1 = activity_tarifekle.findViewById<TextView>(R.id.Kaydetbutton1)
            kaydetbutton1.setOnClickListener{
                Toast.makeText(applicationContext, "Başarılı", Toast.LENGTH_LONG).show()
            }

            }


        binding.tvuyeol.setOnClickListener{
             // AlertDiyalog oluşturalım
            var activity_uyeol =LayoutInflater.from(this).inflate(R.layout.activity_uyeol,null)
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setView(activity_uyeol)
            alertDialog.setNegativeButton("Kapat"){dialog, which ->}
            alertDialog.show()


            //Yeni üye kaydı yapalım
            val Kaydetbutton = activity_uyeol.findViewById<TextView>(R.id.Kaydetbutton)
            Kaydetbutton.setOnClickListener{
                val etkayıtolemail = activity_uyeol.findViewById<TextView>(R.id.etkayıtolemail).text.toString().trim()
                val etkayıtolparola = activity_uyeol.findViewById<TextView>(R.id.etkayıtolparola).text.toString().trim()
                girisemail = etkayıtolemail
                girisparola = etkayıtolparola
                Toast.makeText(applicationContext, "Başarılı", Toast.LENGTH_LONG).show()

            }
        }

        //Giriş İşlemi Yapıyoruz
        binding.girisyapbutton.setOnClickListener {
            val etemail = binding.etemail.text.toString().trim()
            val etparola = binding.etparola.text.toString().trim()
            if (TextUtils.isEmpty(etemail)) {
                binding.etemail.error = "lütfen e-mail adresizinizi giriniz"
            }
            if (TextUtils.isEmpty(etparola)) {
                binding.etparola.error = "lütfen parolanızı giriniz"
            } else {
                if ((girisemail == etemail) && (girisparola == etparola)) {
// AlertDiyalog oluşturalı
                    val alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Başarılı")
                    alertDialog.setNegativeButton("Kapat") { dialog, which -> }
                    alertDialog.show()
                } else {
                    // AlertDiyalog oluşturalı
                    val alertDialog = AlertDialog.Builder(this)
                    alertDialog.setTitle("Hatalı")
                    alertDialog.setNegativeButton("Kapat") { dialog, which -> }
                    alertDialog.show()
                }
            }

        }

    }


}
