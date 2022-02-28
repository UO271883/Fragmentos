package com.example.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.commit
import com.example.fragmentos.databinding.ActivityMainBinding
import org.w3c.dom.Text
var i = 1
val requestkeyf2f : String = "key"
val requestkeyf2a : String = "key2"
val requestkeyc2f : String = "key3"
val TAG : String = "cadena"
val TAG2 : String = "ke"
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            if (i%2 == 0) {
                binding.titulo.text = "Cambia fragmentos " + i
                supportFragmentManager.commit {
                    replace(R.id.fragmentContainerView, FirstFragment())
                    replace (R.id.fragmentContainerView2, SecondFragment())
                    i++
                }
            }
            else {
                binding.titulo.text = "ke"
                supportFragmentManager.commit {
                    replace(R.id.fragmentContainerView2, FirstFragment())
                    replace (R.id.fragmentContainerView, SecondFragment())
                    i++
                }
            }
        }
        supportFragmentManager.setFragmentResultListener(requestkeyf2a, this) { _, bundle ->
            binding.titulo.text = bundle.getString(TAG)
        }
    }
}