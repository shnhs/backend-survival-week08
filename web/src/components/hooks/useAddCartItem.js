import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

export default function useAddCartItem() {
  const addCartItem = async ({ productId }) => {
    console.log('!!!');
    await axios.post(`${BASE_URL}/cart-line-items`, { productId, quantity: 1 });
  };

  const changeQuantity = async ({ id, quantity }) => {
    console.log('!!!222');
    await axios.patch(`${BASE_URL}/cart-line-items/${id}`, { quantity });
  };

  return {
    addCartItem,
    changeQuantity,
  };
}
