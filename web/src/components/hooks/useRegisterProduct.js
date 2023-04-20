import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

export default function useRegisterProduct() {
  const registerProduct = async (data) => {
    await axios.post(`${BASE_URL}/products`, data);
  };

  return {
    registerProduct,
  };
}
