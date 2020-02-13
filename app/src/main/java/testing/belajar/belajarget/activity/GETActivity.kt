package testing.belajar.belajarget.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_get.*
import org.json.JSONArray
import testing.belajar.belajarget.R

class GETActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get)

        data(tvTitle.text.toString(), tvBody.text.toString())
    }

    private fun data(title: String, body: String) {
        AndroidNetworking.get("https://jsonplaceholder.typicode.com/posts")
            .addPathParameter("title", title)
            .addPathParameter("body", body)
            .setTag("GET")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {
                    Log.d("Attention!", "onResponse: $response")

                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}
