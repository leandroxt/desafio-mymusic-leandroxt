import axios from '../config/axios';

export default {
  async searchMusic(filter: string) {
    try {
      const response = await axios.get(`/musicas/?filtro=${filter}`);
      return response.data;
    } catch (error) {
      return [];
    }
  }
}
