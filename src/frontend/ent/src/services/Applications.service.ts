import { api } from 'src/boot/axios';

class ApplicationService {
  getApplications() {
    return api.get('/applications');
  }
}

export default new ApplicationService();
