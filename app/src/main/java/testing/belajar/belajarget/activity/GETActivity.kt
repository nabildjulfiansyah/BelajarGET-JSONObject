package testing.belajar.belajarget.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONException
import org.json.JSONObject
import testing.belajar.belajarget.R

class GETActivity : AppCompatActivity() {

    private lateinit var tvUserId : TextView
    private lateinit var tvId : TextView
    private lateinit var tvTitle : TextView
    private lateinit var tvBody : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)

        tvUserId = findViewById(R.id.tvUserId)
        tvId = findViewById(R.id.tvId)
        tvTitle = findViewById(R.id.tvTitle)
        tvBody = findViewById(R.id.tvBody)

        data()

    }

    private fun data() {
        AndroidNetworking.get("https://jsonplaceholder.typicode.com/posts/1")
            .setTag("GET")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Toast.makeText(this@GETActivity, "sukses", Toast.LENGTH_LONG).show()
                    try {
                        tvUserId.text = response.getInt("userId").toString()
                        tvId.text = response.getInt("id").toString()
                        tvTitle.text = response.getString("title")
                        tvBody.text = response.getString("body")
                    } catch (e : JSONException){
                        e.printStackTrace()
                    }
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(this@GETActivity, "Gagal", Toast.LENGTH_LONG).show()
                }
            })
    }
}
