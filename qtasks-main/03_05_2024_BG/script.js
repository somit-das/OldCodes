const url = "https://bhagavad-gita3.p.rapidapi.com/v2/chapters/?limit=18";
const options = {
  method: "GET",
  headers: {
    "X-RapidAPI-Key": "8ec9eeaf26msh1ffd042d4c47c73p1c2701jsnbceb9a7db5a9",
    "X-RapidAPI-Host": "bhagavad-gita3.p.rapidapi.com",
  },
};

try {

    async function fetchData() {
      const response = await fetch(url,options);
      console.log(response);
      const data = await response.json();
      return data;
    }

    fetchData()
      .then((data) => {
        console.log(data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
//   const response = await fetch(url, options);
//   const result = await response.text();
//   console.log(result);
} catch (error) {
  console.error(error);
}
