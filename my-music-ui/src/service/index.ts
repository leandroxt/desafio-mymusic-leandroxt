import axios from '../config/axios';
import { Music } from '../types';

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
  },

  async addMusic(playlist: string, music: Music) {
    const response = await axios.put(`/playlists/${playlist}/musicas`, music);
    return response.status;
  },

  async deleteMusic(playlistId: string, musicId: string) {
    const response = await axios.delete(`/playlists/${playlistId}/musicas/${musicId}`);
    return response.status;
  }
}
