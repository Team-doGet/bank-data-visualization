const REGION = {
  강원도고성군: { x: 128.4678625, y: 38.3806154 },
  강원도강릉시: { x: 128.875836, y: 37.752175 },
  강원도양구군: { x: 127.99, y: 38.109992 },
  강원도속초시: { x: 128.59184, y: 38.207169 },
  강원도삼척시: { x: 129.1651479, y: 37.4499354 },
  강원도양양군: { x: 128.619145, y: 38.075493 },
  강원도인제군: { x: 128.170352, y: 38.069732 },
  강원도원주시: { x: 127.9199688, y: 37.3423179 },
  강원도영월군: { x: 128.46185, y: 37.183774 },
  강원도정선군: { x: 128.660871, y: 37.380609 },
  강원도동해시: { x: 129.1142625, y: 37.5247583 },
  강원도철원군: { x: 127.313472, y: 38.146861 },
  강원도홍천군: { x: 127.888518, y: 37.697207 },
  강원도평창군: { x: 128.390193, y: 37.37077 },
  강원도태백시: { x: 128.985735, y: 37.164132 },
  강원도춘천시: { x: 127.7300034, y: 37.8813739 },
  강원도화천군: { x: 127.708216, y: 38.106181 },
  경기도과천시: { x: 126.987675, y: 37.4292013 },
  경기도광명시: { x: 126.8646504, y: 37.4786176 },
  경기도고양시: { x: 126.8319831, y: 37.6583981 },
  경기도광주시: { x: 127.2550476, y: 37.4294306 },
  경기도군포시: { x: 126.935338, y: 37.361523 },
  경기도구리시: { x: 127.129632, y: 37.594266 },
  경기도김포시: { x: 126.715544, y: 37.61535 },
  강원도횡성군: { x: 127.985022, y: 37.491803 },
  경기도가평군: { x: 127.509541, y: 37.831508 },
  경기도남양주시: { x: 127.216467, y: 37.635985 },
  경기도동두천시: { x: 127.0606385, y: 37.9036644 },
  경기도부천시: { x: 126.766, y: 37.5035917 },
  경기도성남시: { x: 127.1267772, y: 37.4200267 },
  경기도수원시: { x: 127.028646, y: 37.263476 },
  경기도시흥시: { x: 126.802934, y: 37.380177 },
  경기도안성시: { x: 127.2797732, y: 37.0080546 },
  경기도양주시: { x: 127.045847, y: 37.785329 },
  경기도안양시: { x: 126.9567534, y: 37.3942905 },
  경기도안산시: { x: 126.8308176, y: 37.3219123 },
  경기도양평군: { x: 127.487597, y: 37.491791 },
  경기도연천군: { x: 127.074755, y: 38.096738 },
  경기도오산시: { x: 127.077462, y: 37.149887 },
  경기도용인시: { x: 127.1774916, y: 37.2412522 },
  경기도의왕시: { x: 126.9682786, y: 37.3448869 },
  경기도여주군: { x: 127.637082, y: 37.298342 },
  경기도의정부시: { x: 127.033753, y: 37.738083 },
  경기도이천시: { x: 127.435034, y: 37.272342 },
  경기도평택시: { x: 127.1126947, y: 36.9923537 },
  경기도파주시: { x: 126.779883, y: 37.760186 },
  경기도포천시: { x: 127.2002404, y: 37.894867 },
  경기도하남시: { x: 127.2148742, y: 37.5393014 },
  경기도화성시: { x: 126.831405, y: 37.199565 },
  경상남도거제시: { x: 128.6211703, y: 34.8804572 },
  경상남도거창군: { x: 127.909538, y: 35.686698 },
  경상남도김해시: { x: 128.889322, y: 35.228574 },
  경상남도고성군: { x: 128.3222643, y: 34.9730975 },
  경상남도남해군: { x: 127.892475, y: 34.837707 },
  경상남도밀양시: { x: 128.746712, y: 35.503856 },
  경상남도마산시: { x: 128.579706, y: 35.220932 },
  경상남도사천시: { x: 128.0638649, y: 35.0034774 },
  경상남도양산시: { x: 129.037339, y: 35.335049 },
  경상남도산청군: { x: 127.873458, y: 35.415557 },
  경상남도진주시: { x: 128.107646, y: 35.180325 },
  경상남도창녕군: { x: 128.492346, y: 35.544611 },
  경상남도진해시: { x: 128.710081, y: 35.13306 },
  경상남도통영시: { x: 128.433112, y: 34.85439 },
  경상남도하동군: { x: 127.751275, y: 35.067333 },
  경상남도창원시: { x: 128.6818746, y: 35.2278771 },
  경상남도함안군: { x: 128.406595, y: 35.272315 },
  경상북도경주시: { x: 129.224784, y: 35.856242 },
  경상남도함양군: { x: 127.725245, y: 35.520536 },
  경상북도고령군: { x: 128.263074, y: 35.726177 },
  경상북도경산시: { x: 128.741201, y: 35.82509 },
  경상북도구미시: { x: 128.3443, y: 36.1195987 },
  경상북도김천시: { x: 128.1136148, y: 36.1397714 },
  경상북도문경시: { x: 128.186787, y: 36.586522 },
  경상북도봉화군: { x: 128.732503, y: 36.893114 },
  경상북도상주시: { x: 128.159229, y: 36.411002 },
  경상북도성주군: { x: 128.282959, y: 35.919175 },
  경상북도안동시: { x: 128.7295375, y: 36.568425 },
  경상북도영덕군: { x: 129.365267, y: 36.415034 },
  경상북도영주시: { x: 128.624063, y: 36.805667 },
  경상북도영양군: { x: 129.1123839, y: 36.6667174 },
  경상북도영천시: { x: 128.938613, y: 35.97326 },
  경상북도예천군: { x: 128.4373552, y: 36.6468844 },
  경상북도울진군: { x: 129.400394, y: 36.993087 },
  경상북도의성군: { x: 128.6971711, y: 36.3527158 },
  경상북도청도군: { x: 128.733988, y: 35.647399 },
  경상북도청송군: { x: 129.0571263, y: 36.4362793 },
  경상북도칠곡군: { x: 128.401679, y: 35.9955753 },
  경상북도포항시: { x: 129.3433898, y: 36.0190333 },
  광주시: { x: 126.851338, y: 35.160032 },
  경상북도울릉군: { x: 130.905697, y: 37.484455 },
  서울시: { x: 126.9783882, y: 37.5666103 },
  대전시: { x: 127.3849508, y: 36.3504396 },
  대구시: { x: 128.601763, y: 35.87139 },
  부산시: { x: 129.0750223, y: 35.179816 },
  울산시: { x: 129.3112994, y: 35.5394773 },
  전라남도강진군: { x: 126.7672, y: 34.64209 },
  전라남도고흥군: { x: 127.275507, y: 34.6047049 },
  전라남도곡성군: { x: 127.2919779, y: 35.2820169 },
  인천시: { x: 126.7051505, y: 37.4559418 },
  전라남도구례군: { x: 127.4629375, y: 35.2025096 },
  전라남도광양시: { x: 127.6958987, y: 34.9406575 },
  전라남도나주시: { x: 126.710814, y: 35.015814 },
  전라남도담양군: { x: 126.988175, y: 35.321175 },
  전라남도목포시: { x: 126.3923375, y: 34.811875 },
  전라남도무안군: { x: 126.4817117, y: 34.9904886 },
  전라남도보성군: { x: 127.080088, y: 34.771458 },
  전라남도순천시: { x: 127.487243, y: 34.9506984 },
  전라남도신안군: { x: 126.351124, y: 34.833626 },
  전라남도여수시: { x: 127.662313, y: 34.760425 },
  전라남도영광군: { x: 126.5120143, y: 35.2772127 },
  전라남도영암군: { x: 126.6967961, y: 34.8001638 },
  전라남도완도군: { x: 126.7548524, y: 34.3110391 },
  전라남도장성군: { x: 126.784814, y: 35.301943 },
  전라남도진도군: { x: 126.263475, y: 34.486818 },
  전라남도해남군: { x: 126.5994353, y: 34.5740398 },
  전라남도함평군: { x: 126.5165816, y: 35.065929 },
  전라남도화순군: { x: 126.9864771, y: 35.0645238 },
  전라북도고창군: { x: 126.701973, y: 35.435836 },
  전라남도장흥군: { x: 126.9070507, y: 34.681622 },
  전라북도군산시: { x: 126.736875, y: 35.9676263 },
  전라북도김제시: { x: 126.8808375, y: 35.8035917 },
  전라북도무주군: { x: 127.660818, y: 36.00681 },
  전라북도완주군: { x: 127.162019, y: 35.904708 },
  전라북도장수군: { x: 127.5215208, y: 35.647366 },
  전라북도익산시: { x: 126.957786, y: 35.948295 },
  전라북도부안군: { x: 126.733199, y: 35.731755 },
  전라북도정읍시: { x: 126.856038, y: 35.569867 },
  전라북도남원시: { x: 127.390438, y: 35.416432 },
  전라북도순창군: { x: 127.137489, y: 35.374476 },
  전라북도전주시: { x: 127.14805, y: 35.824171 },
  제주특별자치도제주시: { x: 126.531138, y: 33.499568 },
  충청남도계룡시: { x: 127.248633, y: 36.274554 },
  제주특별자치도서귀포시: { x: 126.5597875, y: 33.253925 },
  충청남도공주시: { x: 127.11904, y: 36.446556 },
  충청남도금산군: { x: 127.488213, y: 36.108857 },
  전라북도진안군: { x: 127.424875, y: 35.7917621 },
  충청남도논산시: { x: 127.0986227, y: 36.1872399 },
  충청남도보령시: { x: 126.612803, y: 36.333452 },
  충청남도부여군: { x: 126.909775, y: 36.275658 },
  충청남도서산시: { x: 126.4502766, y: 36.7849216 },
  충청남도아산시: { x: 127.002474, y: 36.790013 },
  충청남도서천군: { x: 126.6917418, y: 36.080286 },
  충청남도연기군: { x: 127.2894325, y: 36.4803512 },
  충청남도예산군: { x: 126.8447382, y: 36.6808995 },
  충청남도천안시: { x: 127.113892, y: 36.815147 },
  충청남도당진군: { x: 126.6459003, y: 36.8899744 },
  충청남도태안군: { x: 126.297913, y: 36.74561 },
  충청남도청양군: { x: 126.802238, y: 36.459151 },
  충청남도홍성군: { x: 126.660775, y: 36.601324 },
  충청북도단양군: { x: 128.365589, y: 36.984539 },
  충청북도보은군: { x: 127.729485, y: 36.489455 },
  충청북도음성군: { x: 127.690487, y: 36.940282 },
  충청북도옥천군: { x: 127.5714191, y: 36.3064369 },
  충청북도제천시: { x: 128.191037, y: 37.132646 },
  충청북도증평군: { x: 127.581507, y: 36.785345 },
  충청북도괴산군: { x: 127.786704, y: 36.815381 },
  충청북도진천군: { x: 127.435602, y: 36.85542 },
  충청북도청원군: { x: 127.3758644, y: 36.6289675 },
  충청북도청주시: { x: 127.488975, y: 36.6424987 },
  충청북도영동군: { x: 127.783423, y: 36.175047 },
  충청북도충주시: { x: 127.926012, y: 36.991105 },
};
export default REGION;
