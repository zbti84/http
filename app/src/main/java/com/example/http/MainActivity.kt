package com.example.http

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.http.databinding.ActivityMainBinding
import retrofit.RetrofitManager
import utils.Constant

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var button:Button
    private lateinit var button2:Button

    var location : String = "한성대입구역"

    var startx=127.0690745902964
    var starty=37.83296140345568
    var endx=127.0617749485774
    var endy=37.84368779816498
    var startname="%EC%B6%9C%EB%B0%9C"
    var endname="%EB%B3%B8%EC%82%AC"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button=findViewById(R.id.Button)
        button2=findViewById(R.id.Button2)

//        button.setOnClickListener {
//            Log.d("로그", "MainActivity - POI 버튼이 클릭되었다. /")
//
//            // 검색 api 호출
//            //manager에서 인터페이스를 가져오고 호출함수 사용하고
//            RetrofitManager.instance.searchPOI(searchKeyword = location,completion = {
//                responseState, parsePOIDataArray ->
//
//                when(responseState){
//                    Constant.RESPONSE_STATE.OKAY->{  //만약 STATE가 OKEY라면
//                        Log.d("로그", " POI api호출 성공")
//                        if (parsePOIDataArray != null) {
//                            Log.d("결과값", "${parsePOIDataArray.get(0).name}")
//                        }
//                        //그냥 parsePOIDataArray.get(0).name 을 치고 Alt+Enter을 하면 가장 위에 것을 선택하면 오류해결
//
//                    }
//                    Constant.RESPONSE_STATE.FAIL->{//만약 STATE가 FAIL라면
//                        Log.d("로그", " POIapi호출 실패")
//                    }
//                    Constant.RESPONSE_STATE.NO_CONTENT->{//만약 NO_CONTENT가 FAIL라면
//                        Log.d("로그", " POI 결과가 없습니다.")
//                    }
//                }
//            })
//        }

        //button2.setOnClickListener{
            Log.d("로그", "MainActivity - ROUTE 버튼이 클릭되었다. /")

            // 길찾기 호출
            //manager에서 인터페이스를 가져오고 호출함수 사용하고
            RetrofitManager.instance.searchRoute(startX = startx,
                                                startY = starty,
                                                endX = endx,
                                                endY = endy,
                                                startname = startname,
                                                endname = endname,
                completion = {
                    responseState, parseRouteDataArray ->

                when(responseState){
                    Constant.RESPONSE_STATE.OKAY->{  //만약 STATE가 OKEY라면
                        Log.d("로그", " ROUTE api호출 성공")
                        if (parseRouteDataArray != null) {
                            Log.d("결과값","${parseRouteDataArray.toString()}")
                        }


                    }
                    Constant.RESPONSE_STATE.FAIL->{//만약 STATE가 FAIL라면
                        Log.d("로그", " ROUTE api호출 실패")
                    }
                    Constant.RESPONSE_STATE.NO_CONTENT->{//만약 NO_CONTENT가 FAIL라면
                        Log.d("로그", " ROUTE 결과가 없습니다.")
                    }
                }
            })
        }

    //}


}