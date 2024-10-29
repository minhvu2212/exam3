package com.example.exam3

// MainActivity.kt
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: StudentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchEditText = findViewById(R.id.searchEditText)

        setupRecyclerView()
        setupSearchListener()
        loadSampleData()
    }

    private fun setupRecyclerView() {
        adapter = StudentAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupSearchListener() {
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                adapter.filter(s.toString())
            }
        })
    }

    private fun loadSampleData() {
        // Mẫu dữ liệu sinh viên
        val sampleStudents = listOf(
            Student("21211001", "Nguyễn Thị Anh"),
            Student("21211002", "Trần Văn Bình"),
            Student("21211003", "Lê Hoàng Cẩm"),
            Student("21211004", "Phạm Đức Duy"),
            Student("21211005", "Hoàng Mai Em"),
            Student("21211006", "Đặng Thanh Hà"),
            Student("21211007", "Bùi Quang Huy"),
            Student("21211008", "Vũ Thị Lan"),
            Student("21211009", "Ngô Đình Minh"),
            Student("21211010", "Phan Thị Ngọc"),
            Student("21211011", "Mai Văn Phúc"),
            Student("21211012", "Trịnh Thị Quỳnh"),
            Student("21211013", "Lý Hoàng Sơn"),
            Student("21211014", "Đỗ Thị Thanh"),
            Student("21211015", "Hồ Văn Uy"),
            Student("21211016", "Châu An Vi"),
            Student("21211017", "Dương Xuân Yến"),
            Student("21211018", "Tạ Đình Khôi"),
            Student("21211019", "Lương Thị Mỹ"),
            Student("21211020", "Đinh Văn Nam"),
            Student("21211021", "Nguyễn Thị Bích Ngọc"),
            Student("21211022", "Phạm Hoàng Gia Bảo"),
            Student("21211023", "Trần Nguyễn Phương Anh"),
            Student("21211024", "Lê Thị Thanh Trúc"),
            Student("21211025", "Hoàng Minh Tuấn Kiệt"),
            Student("21211026", "Đoàn Thị Ý Nhi"),
            Student("21211027", "Huỳnh Quốc Thắng"),
            Student("21211028", "Võ Thị Ái Vy"),
            Student("21211029", "Bạch Thanh Quý"),
            Student("21211030", "Diệp Vĩnh Ân")
        )
        adapter.setData(sampleStudents)
    }
}