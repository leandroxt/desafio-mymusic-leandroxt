import axios from '../config/axios';

export default {
  async searchMusic(filter: string) {
    try {
      const response = await axios.get(`/musicas/?filtro=${filter}`);
      return response.data;
    } catch (error) {
      return [];
    }
  },

  async searchUserPlaylist(username: string) {
    try {
      const response = await axios.get(`/playlists/?user=${username}`);
      return response.data[0];
    } catch (error) {
      return [];
    }
  }
}
